# **Panoply**

## *Your Wardrobe Log*

Panoply's design mission is to make your outfits effortless. 
Features:
* record your buying 
* classify the clothing you own 
* give your advice about what to wear today. 

This app is for those who have trouble on organizing closet and want to build a systematic, minimalist style wardrobe.
As the developer and shopaholic, I do not have a huge space to store my clothing and I always want to buy new objects. 
So it is a good idea to make a software to help me manage my wardrobe. Hope you guys can enjoy the app and build a 
sustainable lifestyle with me!

**USER STORIES**
1. as a user, I want to add a new buying to the wardrobe with details.
2. as a user, I want to list all my clothing.
3. as a user, I want to search clothing by some filters.
4. as a user, I want to calculate the money spent on clothing given a period of time.
5. as a user, I want to get outfits advice according to given inspirations.
6. as a user, I want to know the total value of my wardrobe.
7. as a user, I want to save the contents of wardrobe to file and load.

How to use GUI:
1. run the WardrobeLog class in ui package.
2. Choose function from the "A menu".
3. audiovisual component--click "Inspire me" and if there are not enough clothing to have an outfit, it would display
a picture as guide.

Phase 4: Task 2
Test and design a class that is robust. Add OutOfDateException to the method "add new clothing" to 
handle the invalid date input. Add 2 tests to MyWardrobeTest.

Phase 4: Task 3
problem1: Low Cohesion of MyWardrobe class: does a great variety of actions like recording spending and adding clothing
improvement: separate the spending methods to another new class called spending

problem2: Too many duplicated sentences in different searching methods and SearchingTool leads to low cohesion
improvement: refactor the search methods to keep only 2 searching criteria: String and int and searching tools are
combined to one ActionTool.

problem3: Low Cohesion of WardrobeLog class: ActionTools and creating ui are in the same classes
improvement: separate the tool classes and use an abstract tool class to manage them