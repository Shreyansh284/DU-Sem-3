const arr=[1,45,6,5,11]
function maxFromArray()
{
    let max=0
    for(let i=0;i<arr.length;i++)
    {

            if(max<arr[i])
            {
                max=arr[i]
            }
    
    }
    console.log(max)
}

// function sortAsc()
// {
//     for(var i=0;i<arr.length;i++)
//     {
//         for(var j=0;j<arr.length-i-1;j++)
//         if(arr[j]>arr[j+1])
//         {
//             let temp = arr[j]
//             arr[j]=arr[j+1]
//             arr[j+1]=temp
       
//         }
//     }
//     console.log(arr)
// }
function sortAsc()
{
    for(var i=0;i<arr.length;i++)
    {
        for(var j=0;j<arr.length;j++)
        if(arr[i]<arr[j])
        {
            // let temp = arr[i]
            // arr[i]=arr[j]
            // arr[j]=temp

            [arr[i],arr[j]]=[arr[j],arr[i]]
       
        }
    }
    console.log(arr)
}
// maxFromArray()
sortAsc()

// let a=10,b=15
// console.log(a,b)
// console.log(([a,b]=[b,a]))
// console.log(a,b)

// console.log(arr.sort)