// 입력모듈 
const readline = require("readline"); 
const rl = readline.createInterface({ 
    input: process.stdin, output: process.stdout, 
}); 
let input=[];
let w,h; 
rl.on("line", function (line) { 
    //line를 통해서 사용자가 입력한 문자열이 들어온다. 
    //w = line; 

    //정수형태로 사용할려면 parseInt로 형변환 필요 
    input.push(line)
    
    //한줄을 받고 입력 종료 
    //rl.close(); 
}).on("close", function () { 
    //개발 로직 작성 //필자의 경우 함수를 이용 
    w = parseInt(input[0])
    h = parseInt(input[1]);
    
    solution(w,h); 
    //프로세스 종료 
    process.exit(); 
});

function solution(w, h) {
    let none = 0;
    let gcd = GCD(w,h);
    let answer = w*h - (w+h-gcd);
    console.log(answer);
    return answer;
}

function GCD(a,b){
    let small = a>b?b:a;
    let big = a>b?a:b;
    
    while(small != 0){
        let n = parseInt(big%small);
        big = small;
        small = n;
        console.log(big)
    }
    return big;
}