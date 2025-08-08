//
//  BoardViewModel.swift
//  iosApp
//
//  Created by Arviejhay Alejandro on 8/6/25.
//

import Shared

class BoardViewModel: ObservableObject {
    var getPostsUseCase: GetPostsForDataUseCase
    var submitPostsUseCase: SubmitPostUseCase
    
    @Published var posts: [Post] = []
    
    init(getPostsUseCase: GetPostsForDataUseCase, submitPostsUseCase: SubmitPostUseCase) {
        self.getPostsUseCase = getPostsUseCase
        self.submitPostsUseCase = submitPostsUseCase
    }
    
    func loadPosts() async {
        do {
            let result = try await getPostsUseCase.invoke(date: "2025-01-01")
            switch result {
            case let success as GetPostResult.Success:
                self.posts = success.posts
            case let failure as GetPostResult.Failure:
                print(failure.exception)
            default:
                break
            }
        } catch {
            // Handle error (e.g., log or set an error state)
            print("Failed to load posts: \(error)")
        }
    }
}
