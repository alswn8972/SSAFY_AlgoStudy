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
    //input = parseInt(line); 
    
    //한줄을 받고 입력 종료 
    rl.close(); 
}).on("close", function () { 
    //개발 로직 작성 //필자의 경우 함수를 이용 
    solution(input); 
    //프로세스 종료 
    process.exit(); 
});

function solution(numbers) { 
    var answer = 0; 
    // numbers를 배열로 변환하고 내림차순으로 정렬 
    let a = numbers.split('').sort((a,b)=>b-a); 
    // 최댓값 
    let N = Number(a.join('')); 
    
    // 에라토스 테네스의 체로 소수 구하기 
    let arr = makePrimeNum(N); 
    for(let i=2; i<=N; i++){ 
        // 소수가 아니면 패스 
        if(arr[i] == false) continue; 

        // 소수면 해당 숫자를 문자열로 바꾸고 배열로 변환 
        let temp = i.toString().split(''); 
        // numbers에 해당 하는 값을 돌면서 temp에도 있으면 temp에서 삭제 
        for(let cn of a){ 
            let idx = temp.indexOf(cn); 
            if(idx > -1) temp.splice(idx,1); 
        } 
        // temp.length가 0이면 numbers에 모두 있는 숫자 이므로 answer++ 
        if(temp.length == 0) answer++; 
    } 
    console.log(answer)
    return answer; 
} 
//에라토스테네스의 체 
function makePrimeNum(N){ 
    let arr = []; 
    for(let i=2; i<=N; i++){ 
        if(arr[i] == false) continue; 
        for(let k=i+i; k<=N; k+=i){ 
            arr[k] = false; 
        } 
    } 
    return arr; 
}


// function solution(numbers) {
//     const arr = numbers.split('');
//     let selected = 0;
//     makePowerSet(arr, 0, selected);
//     return cnt;
// }
// let primes = new Set([]);
// let cnt = 0;
// function makePowerSet(arr, cnt, selected){
//     console.log(selected)
//     if(cnt==arr.length){
//         // check prime number
//         if(isPrime(selected)){
//             cnt++;
//         }
//         return;
//     }
        
//     makePowerSet(arr, cnt+1, selected.push(arr[cnt]));
//     makePowerSet(arr, cnt+1, selected);
// }

// function isPrime(arr){
//     // arr to int
//     let num = 0;
//     for(let i = arr.length - 1; i>=0; i--){
//         if(i==0 && arr[i]==0)continue;
//         num += arr[i]*10*(arr.length - i +1)
//     }
//     console.log(num)
    
//     if(num == 1)return false;

//     // check prime
//     let res = true;
//     for(let i = 2; i<num; i++){
//         if(num%i == 0){
//             res = false;
//             break;
//         }
//     }
//     return res;
// }