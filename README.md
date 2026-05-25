# MyArrayList - Sequential List Implementation

> Abstract Data Type (ADT) implementation of a Sequential List (Array-Based List) in Java.

This repository contains the fundamental data manipulation operations, dynamic resizing logic, and classical array management algorithms for a custom Sequential List structure.

## ⚙️ How it Works

A Sequential List is a linear data structure where elements are stored in contiguous memory locations, utilizing an internal array as its foundation.

* Unlike a standard fixed array, this structure abstractly manages its own capacity.
* It utilizes an internal array to hold the data and an integer tracking the current `size` (the number of valid, occupied positions).
* When the internal array reaches its maximum capacity, the structure automatically creates a new, larger array and copies the existing elements over, giving the illusion of an infinitely expanding list.
* Elements are accessed directly through numerical indices, starting from zero.

## 💡 The Why: Advantages and Utility

Implementing this data structure highlights the trade-offs between memory management and processing speed. Here are the main reasons sequential lists are widely used:

* **Instant access (Indexing):** Retrieving an element by its index has a time complexity of `O(1)`. You do not need to traverse the structure to find the item in a specific position.
* **Cache friendliness:** Because the memory is contiguous, modern CPUs can pre-fetch the data highly efficiently, making loops and iterations significantly faster than pointer-based structures.
* **Low memory overhead:** There is no need to allocate extra memory for pointers or references (like the `next` node in linked lists). The structure only stores the actual data.

## 🚀 When to use in applications

In modern software development, structures based on dynamic arrays (like Java's native `ArrayList`) are often the default choice for linear data. Use sequential list concepts in scenarios such as:

* **Music playlists and media queues:** Applications that require indexing to skip directly to a specific track, shuffle elements efficiently, or read data sequentially without frequent insertions in the middle of the list.
* **Data visualization and tables:** Rendering leaderboards, product catalogs, or dashboards where the system reads data much more frequently than it modifies it.
* **High-performance iterations:** Systems that process batches of data and require maximum CPU cache efficiency, where contiguous memory is a strict requirement.

## 📂 Project Structure

* `ArrayListTAD.java`: Interface that defines the contract for the data structure operations (e.g., add, remove, get, size).
* `MyArrayList.java`: Concrete implementation of the interface. This class manages the internal array, the `size` counter, and the dynamic array resizing logic (expanding capacity when full).
* `Main.java`: Interactive Command Line Interface (CLI) to test the functionalities, add or remove elements, and visualize the structure's behavior and capacity changes in real time.
