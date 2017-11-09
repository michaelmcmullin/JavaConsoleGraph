# Java Console Graph
We were given a few exercises near the beginning of our Java course recently, one of which
was to render a 'vertical' Sine wave in the console. It was a fairly simple exercise to 
get started with basic calculations, `for` loops and console output.

I decided to play around with it a bit, making the following enhancements:

* Added x and y axes.
* Rotated the graph to the more commonly used orientation.
* Changed the drawing mechanism to use Lambda Expressions

Using Lambda's was a lot of fun, and meant that many other functions could be rendered on
the one graph. I was familiar with them from C#, so was delighted to learn that Java
supports them too!

Here is some sample output, rendering a Cosine and Sine Wave on the one graph:

```
                                   |                                            
                                   |                                            
                                 *****         #####                            
                              ***  |  ***   ###     ###                         
#                            *     |     *##           #                        
 ##                        **      |     # *            ##                      
   #                      *        |    #   *             #                     
    #                    *         |  ##     **            #                    
     #                 **          | #         *            ##                  
      #               *            |#           *             #               * 
-------##------------*-------------#-------------*-------------#------------**--
         #          *             #|              *             #          *    
          #        *             # |               *             #        *     
           #      *             #  |                *             #      *      
            #    *            ##   |                 **            #    *       
*            ##**            #     |                   *            ##**        
 **          **#           ##      |                    **           *##        
   **      **   ###      ##        |                      **      ***   ##      
     ******        ######          |                        ******        ##### 
```

There are a few more sample functions in the `main` method (commented out) to get you
started, or try a few of your own. The above graph is created by the following code:

```
initGraph(true);
drawFunction('*', x -> Math.cos(x));
drawFunction('#', x -> Math.sin(x));
printGraph();
```

At the moment, I'm pretty sure it's not bulletproof, but seems to work fairly well. Play
around with some of the constants too for different size graphs and ranges. Enjoy!
