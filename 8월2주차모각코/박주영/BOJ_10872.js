//개발 로직 함수 
function solution(input) { 
    console.log(factorial(input));
 } 
//모듈 
const readline = require("readline"); 
const rl = readline.createInterface({ 
    input: process.stdin, output: process.stdout, 
}); 
let input; 
rl.on("line", function (line) { 
    //line를 통해서 사용자가 입력한 문자열이 들어온다. 
    input = line; 

    //정수형태로 사용할려면 parseInt로 형변환 필요 
    input = parseInt(line); 
    
    //한줄을 받고 입력 종료 
    rl.close(); 
}).on("close", function () { 
    //개발 로직 작성 //필자의 경우 함수를 이용 
    solution(input); 
    //프로세스 종료 
    process.exit(); 
});


function factorial(num) {
    if (num <= 1) {
        return 1;
    }

    return num * factorial(num - 1);
}