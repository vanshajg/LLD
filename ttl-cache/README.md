# Question
[source](https://leetcode.com/discuss/interview-question/object-oriented-design/3489444/Machine-Coding-or-Design-System-which-hold-Elements-with-TTL-defined-in-system-or-Quince-or-Round-1)

Design System which hold Elements with TTL defined in system.
Methods can be used :-
```
     put(key)
    get() -> return all the elements with frequency count
```
   

Example :- TTL is 2 Sec
- put :- A(at 1 sec) B(at 1 sec)
- put :- A(at 2 Sec)
- Put: - A(at 3 sec)

if get is called just after 2 seconds Result should be -> {A:2, B:1}
if get is called just after 3 seconds Result should be -> {A;2}