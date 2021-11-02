package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {
	//[40, 93, 30, 55, 60, 65], [60, 1, 30, 5, 10, 7]
	public static void main(String[] args) {
		int[] progress = { 40, 93, 30, 55, 60, 65};
		int[] speeds = { 60, 1, 30, 5, 10, 7 };
		solution(progress, speeds);
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < progresses.length; i++) {
			q.add(progresses[i]);
		}
		List<Integer> list = new ArrayList<>();
		int pro;
		int count = 0;
		int start =0;
		while (!q.isEmpty()) {
			count = 0;
			for (int i = start; i < progresses.length; i++) {
				pro = q.poll() + speeds[i];
				q.add(pro);
			}
			while (!q.isEmpty()) {
				if (q.peek() >= 100) {
					q.poll();
					count++;
					start++;
					
				} else {
					break;
				}
			}
			if (count > 0)
				list.add(count);

		}

		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		System.out.println(list);
		return answer;
	}

}
