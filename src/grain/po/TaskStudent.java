package grain.po;

public class TaskStudent {
	private String task_id;
	private String student_id;
	private int difficulty_level;
	private int duration_day;
	private int clocked;
	private int total_day;
	
	public TaskStudent() {}
	
	public TaskStudent(String task_id, String student_id) {
		super();
		this.task_id = task_id;
		this.student_id = student_id;
		this.difficulty_level = 0;
		this.duration_day = 0;
		this.clocked = 0;
		this.total_day = 0;
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
	public int getDuration_day() {
        return duration_day;
    }
    public void setDuration_day(int duration_day) {
        this.duration_day = duration_day;
    }
    public int getClocked() {
        return clocked;
    }
    public void setClocked(int clocked) {
        this.clocked = clocked;
    }
    public int getTotal_day() {
        return total_day;
    }
    public void setTotal_day(int total_day) {
        this.total_day = total_day;
    }

    @Override
    public String toString() {
        return "TaskStudent [task_id=" + task_id + ", student_id=" + student_id + ", difficulty_level="
                + difficulty_level + ", duration_day=" + duration_day + ", clocked=" + clocked + ", total_day="
                + total_day + "]";
    }
	
}
