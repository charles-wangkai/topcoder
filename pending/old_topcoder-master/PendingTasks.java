import java.util.ArrayList;

public class PendingTasks {
	Task tasks[];
	public int latestProcess(int[] supertasks) {
		int taskNum=supertasks.length;
		tasks=new Task[taskNum];
		for (int i=0;i<taskNum;i++) {
			tasks[i]=new Task();
		}
		for (int i=0;i<taskNum-1;i++) {
			tasks[supertasks[i]].children.add(i);
		}
		search(taskNum-1);
		return tasks[taskNum-1].finish_min-1;
	}
	
	void search(int index) {
		for (int i=0;i<tasks[index].children.size();i++) {
			search(tasks[index].children.get(i));
		}
		tasks[index].finish_max=1;
		for (int i=0;i<tasks[index].children.size();i++) {
			tasks[index].finish_max+=tasks[tasks[index].children.get(i)].finish_max;
		}
		if (tasks[index].children.size()<2) {
			tasks[index].finish_min=tasks[index].finish_max;
			tasks[index].unfinish_max=tasks[index].finish_max-1;
		}
		else {
			tasks[index].finish_min=-1;
			for (int i=0;i<tasks[index].children.size();i++) {
				for (int j=0;j<tasks[index].children.size();j++) {
					if (i!=j) {
						int temp=tasks[tasks[index].children.get(i)].finish_max+tasks[tasks[index].children.get(j)].finish_min;
						for (int k=0;k<tasks[index].children.size();k++) {
							if (k!=i && k!=j) {
								temp+=tasks[tasks[index].children.get(k)].unfinish_max;
							}
						}
						tasks[index].finish_min=Math.max(tasks[index].finish_min, temp);
					}
				}
			}
			tasks[index].finish_min++;
			tasks[index].unfinish_max=-1;
			for (int i=0;i<tasks[index].children.size();i++) {
				Task task=tasks[tasks[index].children.get(i)];
				tasks[index].unfinish_max=Math.max(tasks[index].unfinish_max, task.finish_max-task.unfinish_max);
			}
			for (int i=0;i<tasks[index].children.size();i++) {
				tasks[index].unfinish_max+=tasks[tasks[index].children.get(i)].unfinish_max;
			}
		}
	}
	
	class Task {
		ArrayList<Integer> children;
		int finish_min;
		int finish_max;
		int unfinish_max;
		
		Task() {
			children=new ArrayList<Integer>();
		}
	}
}
