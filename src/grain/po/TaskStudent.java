package grain.po;

public class TaskStudent {
	private String task_id;
	private String student_id;
	private int difficulty_level;
	
	public TaskStudent() {}
	
	public TaskStudent(String task_id, String student_id) {
		super();
		this.task_id = task_id;
		this.student_id = student_id;
		this.difficulty_level = 0;
	}

	public String getTask_id() {
		return task_id;
	}
	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public int getDifficulty_level() {
		return difficulty_level;
	}
	public void setDifficulty_level(int difficulty_level) {
		this.difficulty_level = difficulty_level;
	}
	@Override
	public String toString() {
		return "TaskStudent [task_id=" + task_id + ", student_id=" + student_id + ", difficulty_level="
				+ difficulty_level + "]";
	}
	
}
