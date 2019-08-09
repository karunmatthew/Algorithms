package org.km.algorithms.dynamicProgramming;

public class JobScheduling {

	public static int n = 6;
	public static int bestChooseVal[] = new int[n];
	public static int bestNotChooseVal[] = new int[n];

	public static void main(String[] args) {

		Job[] jobs = new Job[n];

		for (int i = 0; i < n; i++) {
			bestChooseVal[i] = -1;
			bestNotChooseVal[i] = -1;
		}

		Job job1 = new Job(1, 3, 5);
		Job job2 = new Job(2, 5, 6);
		Job job3 = new Job(4, 6, 5);
		Job job4 = new Job(6, 8, 4);
		Job job5 = new Job(5, 8, 10);
		Job job6 = new Job(7, 9, 3);

		jobs[0] = job1;
		jobs[1] = job2;
		jobs[2] = job3;
		jobs[3] = job4;
		jobs[4] = job5;
		jobs[5] = job6;

//		for (int i = 0; i < n; i++) {
//			int startTime = (int) (Math.random() * 100);
//			int endTime = startTime + (int) (Math.random() * 5);
//			Job job = new Job(startTime, endTime, (int) (Math.random() * 100));
//			jobs[i] = job;
//		}

		System.out.println(selectJobs(jobs, 0, 0));

	}

	public static int selectJobs(Job[] jobs, int index, int endTime) {

		if (index >= jobs.length) {
			return 0;
		} else {
			int valueChoose = 0;
			int valueNotChoose = 0;
			// choose the job if possible
			if (jobs[index].startTime >= endTime) {

				if (bestChooseVal[index] == -1) {
					valueChoose = jobs[index].value + selectJobs(jobs, index + 1, jobs[index].endTime);
					bestChooseVal[index] = valueChoose;
				} else {
					valueChoose = bestChooseVal[index];
				}
			}

			if (bestNotChooseVal[index] != -1) {
				valueNotChoose = bestNotChooseVal[index];
			} else {
				valueNotChoose = selectJobs(jobs, index + 1, endTime);
				bestNotChooseVal[index] = valueNotChoose;
			}
			return Math.max(valueChoose, valueNotChoose);
		}

	}
}

class Job {
	int startTime;
	int endTime;
	int value;

	Job(int startTime, int endTime, int value) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.value = value;
	}
}
