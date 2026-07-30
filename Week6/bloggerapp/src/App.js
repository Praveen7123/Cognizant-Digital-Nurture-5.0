import React from "react";
import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";

function App() {
    const showBook = true;
    const showBlog = true;
    const page = "course";

    let bookContent;
    if (showBook) {
        bookContent = <BookDetails />;
    } else {
        bookContent = <p>No book to show</p>;
    }

    return (
        <div>
            <h1>Blogger App - Conditional Rendering</h1>

            {bookContent}

            {showBlog ? <BlogDetails /> : <p>No blog to show</p>}

            {page === "course" && <CourseDetails />}
        </div>
    );
}

export default App;
