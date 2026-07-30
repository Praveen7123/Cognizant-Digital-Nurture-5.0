import React, { Component } from "react";

class Posts extends Component {
    // 1. initialize state with an empty list of posts
    constructor(props) {
        super(props);
        this.state = {
            posts: []
        };
    }

    // 2. use Fetch API to get posts and store them in state
    loadPosts() {
        fetch("https://jsonplaceholder.typicode.com/posts")
            .then((response) => response.json())
            .then((data) => {
                this.setState({ posts: data });
            });
    }

    // 3. runs automatically after the component appears -> load the posts
    componentDidMount() {
        this.loadPosts();
    }

    // 4. catches any error in this component and shows it as an alert
    componentDidCatch(error, info) {
        alert("Error occurred: " + error);
    }

    // 5. display each post's title (heading) and body (paragraph)
    render() {
        return (
            <div>
                <h1>Blog Posts</h1>
                {this.state.posts.map((post) => (
                    <div key={post.id}>
                        <h3>{post.title}</h3>
                        <p>{post.body}</p>
                    </div>
                ))}
            </div>
        );
    }
}

export default Posts;
