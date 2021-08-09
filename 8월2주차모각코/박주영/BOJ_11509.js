// 입력모듈 
const readline = require("readline")
const rl = readline.createInterface({ 
    input: process.stdin, 
    output: process.stdout, 
})
let input = []
let n
let arr = []
rl.on("line", function (line) { 
    //line를 통해서 사용자가 입력한 문자열이 들어온다. 
    input.push(line)

    //입력 종료하려면 ctrl+D
}).on("close", function () { 
    n = parseInt(input[0])
    arr = input[1].split(' ').map(item=>parseInt(item))
    //개발 로직 작성 
    solution(n, arr)
    //프로세스 종료 
    process.exit()
})

//개발 로직 함수 
function solution(n, arr) { 
    let cnt = 0
    const max = 1000000+1
    let heights = new Array(max)
    for(let i = 0; i<max; i++){
        heights[i] = 0
    }

    for(let i = 0; i<arr.length; i++){
        if(heights[arr[i]+1] == 0){
            heights[arr[i]]++
            cnt++
        }
        else{
            heights[arr[i]+1]--
            heights[arr[i]]++
        }
    }
    console.log(cnt)
}