function solution(n, times) {
    times.sort(function(a, b) {
      return a - b;
    });
    let left = 0;
    let right = n*times[times.length-1];
    let mid = 0;
    var answer = right;
    while(left<=right){
        mid = parseInt((left+right)/2);
        let sum = 0;
        for(let i = 0; i<times.length; i++){
            sum += parseInt(mid / times[i]);
        }
        if(sum<n){
            left = mid+1;
        }
        else {
            answer = Math.min(mid, answer);
            right = mid-1;
        }
    }
    return answer;
}