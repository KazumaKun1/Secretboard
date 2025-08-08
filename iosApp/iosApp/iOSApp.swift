import SwiftUI
import Firebase
import Shared

class AppDelegate: NSObject, UIApplicationDelegate {
  func application(_ application: UIApplication,
                   didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
    FirebaseApp.configure()

    return true
  }
}

@main
struct iOSApp: App {
    
    @UIApplicationDelegateAdaptor(AppDelegate.self) var delegate
    
    let model = {
        let api = PostApiServiceImpl()
        
        let repo = PostRepositoryImpl(api: api)
        
        let getPosts = GetPostsForDataUseCase(repository: repo)
        let submitPost = SubmitPostUseCase(repository: repo)
        
        return BoardViewModel(
            getPostsUseCase: getPosts,
            submitPostsUseCase: submitPost
        )
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView(viewModel: model())
        }
    }
}
