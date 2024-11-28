# NoteEditorApp
A simple Note Editor app
# Explanation of How the Note Editor App Works

This app allows users to create, view and interact with notes. Here's a breakdown of the functionalities:

## 1. **Posting Notes**
   - Users type a note in the provided `EditText` field.
   - When the **"Post Note"** button is clicked, the text is saved as a new `Note` object, along with the author's name (default: "Anonymous").
   - The new note is added to a list (`RecyclerView`), which dynamically updates to display all posted notes.

---

## 2. **Viewing Notes**
   - All notes are displayed in a vertical list using a `RecyclerView`.
   - Each note displays:
     - The note text.
     - The author of the note.
     - Buttons for liking, disliking, and commenting.

---

## 3. **Liking and Disliking Notes**
   - Each note has a **"Like"** and **"Dislike"** button.
   - Clicking the **"Like"** button increases the note's `likes` counter.
   - Clicking the **"Dislike"** button increases the note's `dislikes` counter.
   - The counters are updated in real-time in the displayed list.

---

## 4. **Commenting on Notes**
   - A **"Comment"** button is available for each note.
   - When clicked, it triggers functionality (e.g., opening a new activity or dialog) to add/view comments.
   - This can be extended to allow threaded discussions for each note.

---

## 5. **Dynamic Updates**
   - The app uses a `RecyclerView` and a custom `Adapter` to manage notes.
   - Whenever a note is added, liked, or disliked, the list updates instantly without restarting the app.

---

## 6. **Scalable Design**
   - The `Note` model allows flexibility for future extensions, such as:
     - Adding timestamps.
     - Assigning unique authors (e.g., logged-in users).
     - Saving data persistently (e.g., in a database or cloud storage).
    
# **How to run Your Note Editor App**

## 1. **Clone My git Repository**
- `git clone https://github.com/mua2022/NoteEditorApp.git`
## 2. **Open the project using Android Studio**
- Run Android Studio and open the `cloned` **NoteEditorApp Project**
## 3. **Run the App**
  - Connect a physical Android device or use an emulator.
  - Run the app and test the note-editor app functionalities.

This app demonstrates a simple, interactive interface for posting and engaging with notes. It can serve as the foundation for more complex note-taking or social apps.

**Hope you enjoyed interacting with it !! HURRAY !!!**


