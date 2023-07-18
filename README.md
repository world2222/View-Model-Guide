# View-Model-Guide

### What is ViewModel? And why use ViewModel??
We learned what is "remember" and "mutableStateOf" last time!  
And then, it'll be easier to know what is ViewModel.  

First let's talk about the life cycle.  
There're many steps on the life cycle and when we launch the app and get to the screen. It'll start the life cycle of the screen.  
And here, for example, after you launched the app and screen is showed up, what happen if you rotate your phone?

## The life cycle resets and starts again!!

So, what's the problem here?? Let's assume that we wrote a code like this.
```kotlin
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewmodelguideTheme {
                var currentNumber by remember {
                    mutableStateOf(0)
                }
                var backgroundColor by remember {
                    mutableStateOf(Color.White)
                }
                Box(
                    Modifier.background(backgroundColor)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = currentNumber.toString(),
                            fontSize = 60.sp
                        )
                        Button(onClick = {
                            currentNumber++
                        }) {
                            Text(text = "Add")
                        }
                        Button(onClick = {
                            backgroundColor = Color.Cyan
                        }) {
                            Text(text = "Change background color")
                        }
                    }
                }
            }
        }
    }
}
```
So here, you can see "currenNumber" and "backgroudnColor" are declared with "remember" with "mutableStateOf" to keep its state even after I touched the buttons and the value has changed.  
But what would happen if I rotate this phone?  
Our expectation would be like, it should keep its state cuz that's the reason why we used those features BUT take a look at here!  
***
![ezgif com-video-to-gif](https://github.com/world2222/View-Model-Guide/assets/52661837/3f3ef1d1-7ebd-4229-8120-a9920e7e7de7)  
As you can see the number and background color reset as 0 and white!!  
This is the reason why we use "ViewModel"  

***
### How??
Check the two classes from the app -> src -> main -> java/com/...  
You can see I separated as two classes.  

So by doing this, you can let the var or fun in VieModel to survive even when it restarts the whole code in MainActivity after rotating the phone.  
And from MainActiviy, you can see they are getting values from ViewModel which is still alive from the life cycle restart and keeping the values the same as before.  
And it'll be like this!  
***
![ezgif com-video-to-gif (2)](https://github.com/world2222/View-Model-Guide/assets/52661837/ec41913c-fc44-4cc5-82c6-830c93953d79)  

ViewModel is really important for deveopling all the apps so make sure to fully understand what it is, why using it, and how to use it!
