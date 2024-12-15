// Pattern1

// for (let i = 0; i <= 5; i++) {
//   let buffer = "";
//   for (let j = 0; j <= i; j++) {
//     buffer += "*";
//   }
//   console.log(buffer);
// }

// Pattern 2

// for(let i=5;i>=1;i--)
// {
//     let buffer =""
//     for(let space=1 ; space<5-i+1; space++)
//     {
//         buffer+=" "
//     }

//     for(let j = i; j>=1; j--)
//     {
//         buffer+="* "
//     }

//     console.log(buffer)
// }


// Pattern 3

// for(let i=1;i<=5;i++)
// {
//     let buffer =""
//     for(let space=1 ; space<=5-i; space++)
//     {
//         buffer+=" "
//     }

//     for(let j = 1; j<=i; j++)
//     {
//         buffer+="*"
//     }

//     console.log(buffer)
// }

// // Pattern 5

// for(let i=5;i>=1;i--)
// {
//     let buffer =""
//     for(let space=1 ; space<=5-i; space++)
//     {
//         buffer+=" "
//     }

//     for(let j = i; j>=1; j--)
//     {
//         buffer+="*"
//     }

//     console.log(buffer)
// }

// last

// let k=1
// for(let i=1 ;i<=5;i++)
// {
//     let buffer="";
//     for(let j=1;j<=i;j++)
//     {
//         buffer+=`${k} `
//         k++
//     }
//     console.log(buffer)
// }

//  SQURE BORBER

// for(i=1;i<=5;i++)
// {
//     let buffer=""
// for(let j=1;j<=5;j++)
// {
//     if(i==1||i==5||j==1||j==5)
//     {
//         buffer+="* "
//     }
//     else
//     {
//         buffer+="  "
//     }
// }
//      console.log(buffer)   

// }

// reverse TRINGLE BORDER

// Pattern 5
function borderedInvertedTringale()
{

    console.log("BorderedInvertedTringale")

for(let i=5;i>=1;i--)
{
    let buffer =""
    for(let space=1 ; space<=5-i; space++)
    {
        buffer+=" "
    }

    for(let j = i; j>=1; j--)
    {
          if(i==j||i==5||j==1||j==5)
    {
        buffer+="* "
    }
    else
    {
        buffer+="  "
    }
    }

    console.log(buffer)
}
}


//  TRINGLE BORDER

function borderedTringale()
{
    console.log("BorderedTringale")
    for(let i=1;i<=5;i++)
{
    let buffer =""
    for(let space=1 ; space<=5-i; space++)
    {
        buffer+=" "
    }

    for(let j = i; j>=1; j--)
    {
          if(i==j||i==5||j==1||j==5)
    {
        buffer+="* "
    }
    else
    {
        buffer+="  "
    }
    }

    console.log(buffer)
}
}

function diemond ()
{
    // Upper Part
console.log("Diemond")
    for(let i=1;i<=5;i++)
        {
            let buffer =""
            for(let space=1 ; space<=5-i; space++)
            {
                buffer+=" "
            }
        
            for(let j = i; j>=1; j--)
            {
                  if(i==j||j==1||j==5)
            {
                buffer+="* "
            }
            else
            {
                buffer+="  "
            }
            }
        
            console.log(buffer)
        }
// Lower Part
        for(let i=5;i>=1;i--)
            {
                let buffer =""
                for(let space=1 ; space<=5-i; space++)
                {
                    buffer+=" "
                }
            
                for(let j = i; j>=1; j--)
                {
                      if(i==j||j==1||j==5)
                {
                    buffer+="* "
                }
                else
                {
                    buffer+="  "
                }
                }
            
                console.log(buffer)
            }

}

function sandClock()
{
    console.log("Sand Clock")
    // upper part
    for(let i=5;i>=1;i--)
        {
            let buffer =""
            for(let space=1 ; space<=5-i; space++)
            {
                buffer+=" "
            }
        
            for(let j = i; j>=1; j--)
            {
                  if(i==j||i==5||j==1||j==5)
            {
                buffer+="* "
            }
            else
            {
                buffer+="  "
            }
            }
        
            console.log(buffer)
        }

        for(let i=2;i<=5;i++)
            {
                let buffer =""
                for(let space=1 ; space<=5-i; space++)
                {
                    buffer+=" "
                }
            
                for(let j = i; j>=1; j--)
                {
                      if(i==j||i==5||j==1||j==5)
                {
                    buffer+="* "
                }
                else
                {
                    buffer+="  "
                }
                }
            
                console.log(buffer)
            }

}

borderedTringale()
borderedInvertedTringale()
sandClock()
diemond()

