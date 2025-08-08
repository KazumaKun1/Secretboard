import SwiftUI
import Shared

struct ContentView: View {
    @StateObject var viewModel: BoardViewModel
    
    init(viewModel: BoardViewModel) {
        _viewModel = StateObject(wrappedValue: viewModel)
    }
    
    var body: some View {
        VStack {
            List(viewModel.posts, id: \.id) { post in
                Section(header: Text(post.name ?? "")) {
                    Text(post.title ?? "")
                    Text(post.message)
                }
            }
            .listStyle(.insetGrouped)
        }
        .onAppear {
            Task {
                await viewModel.loadPosts()
            }
        }
    }
}
