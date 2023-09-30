# WordLadder

Word ladder puzzles were invented by Lewis Carroll, the author of Alice in Wonderland, in 1878. In a word ladder puzzle, you change one word into another by altering a single letter each "step". Each word in the ladder must be a valid English word and must have the same length. For example, to turn stone into money, one possible ladder is:
	stone  store  shore  chore  choke  choky  cooky  cooey  coney  money
 
Many puzzles have multiple solutions; in this lab you will write a program that will find the shortest ladder.

Using the starting and ending words from the file called "input.txt", your task is to write a program that will build a word ladder between the starting and ending words.
There are several ways to solve this problem - one method involves using stacks and queues! You will see in my implementation I use differnt kinds of data structures, including stacks, queues, and ArrayLists.

You must keep the track of used words, otherwise an infinite loop occurs.

Using the "dictionary.txt" file, your program must output (to the console) a word ladder, from the start word to the end word (taken from the input file). Every word in the ladder must be a word that appears in the dictionary (this includes the given start and end words). 

Remember that there may be more than one ladder between the start word and the end word. Your program may output any of these ladders (always trying to find the shortest ladder, of course). The first output word must be the start word and the last output word must be the end word. If there is no way to make a ladder from the start word to the end word, your program must output There is no word ladder between...
If done correctly, your program should produce the output seen in the "output.txt" file.  

**Pieces of Advice:**

Test your methods as you go – don't wait until you've coded the entire project to test that individual components work.

Make your algorithim efficient (otherwise it'll take up to an hour to receive output!). If you test my algorithim, you will notice that it is able to print the first 8 pairs (from the input file) after a minute, however it will take 10-15mins to print all outputs. So, try to find some innovative ways to make your code even better.

Start by looking at the input and dictionary files, what differences do you notice between how the words are stored?

IMPORTANT Note: If you discover that your program is running out of memory, find a way to increase the heap size of the Java Virtual Machine (JVM).
