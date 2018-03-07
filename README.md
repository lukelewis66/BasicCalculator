# BasicCalculator

A basic calculator written in Java which uses swing for its UI. 

Implements the Command design pattern to be able to have an undo feature by initializing a command class at each arithmetic operation and pushing it onto a stack, then popping from the top of the stack when the user clicks undo. 

The calculator also keeps a log of operations, and uses the Strategy design pattern to be able to save said log in either text or pseudo-xml format. 
