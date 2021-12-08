# Group 11 
Valerio Costantino, Antonio Iannaccone, Rocco Michele Capobianco, Andrea Grimaldi
***
##Complex Calculator
This project implements a calculator that supports operations with complex numbers. The numbers are pushed in a stack, the GUI shows
all inserted numbers. The user can insert numbers and operations with a text field. 
The supported operations are: 
###Basic Operations:
+ implements addition of the first two elements on the top of the stack, 
- implements subtraction of the first two elements on the top of the stack,
/ implements division of the first two elements on the top of the stack,
* implements multiplication of the first two elements on the top of the stack,
sqrt implements square root of the first element on the top of the stack,
+- implements sign inversion of the first element on the top of the stack,
###Stack Operations:
swap implements the switch of the first two numbers on the top of the stack
dup implements the duplication of the last inserted number
clear deletes all the elements in the stack
over implements the insertion of a copy of second last element
drop deletes the last inserted element
###Memory Operations: (the variables go from a to z)
>var implements the saving of the number on the top of the stack in the variable "var"
<var implements the insertion of the number in the variable "var" on the top of the stack
+var implements the incrementation of the number in the variable "var" with the element on the top of the stack
-var implements the decrementation of the number in the variable "var" with the element on the top of the stack
save implements the saving of the variables from memory to a variables stack
restore implements the loading of the variables from a variables stack to memory
###Trascendental Operations
mod implements modulus,
arg calculates the phase of the number on the top of the stack,
sin calculates the sine of the number on the top of the stack,
cos calculates the cosine of the number on the top of the stack,
tan calculates the tangent of the number on the top of the stack,
asin calculates the arc sine of the number on the top of the stack,
acos calculates the arc cosine of the number on the top of the stack,
atan calculates the arc tangent of the number on the top of the stack,
pow implements the power of the number on the top of the stack,
log implements natural logarithm of the number on the top of the stack,
exp implements exponential of the number on the top of the stack.
###User Defined Operation 
The user can define custom operation following the pattern: "operation_name: [sequence_of_operations]". It's also possible to modify and delete 
custom operation with the command "modify operation_name: [sequence_of_operations]" and "del operation_name". 
In the GUI there is a button with three options: Save, Reload and Clear File.
Save implements the saving of the defined custom operations into a file
Reload implements the loading of custom operations from the previously saved file
Clear File deletes the custom operations previously saved into the file
###Alert
When an operation fails an alert is shown.
