package grain.dto;

import java.sql.Date;

import grain.po.TaskResult;

public class TaskResultSimpleInf {
	private String task_res_id;
	private Date date;
	private float score;
	private int time;
	private String comments;
	private float tch_score;
	private String tch_comment;
	private int clock_rank;
	
	public TaskResultSimpleInf() {}
	
	public TaskResultSimpleInf(TaskResult taskResult) {
		this.task_res_id = taskResult.getTask_result_id();
		this.date = new Date(taskResult.getPublish_time().getTime());
		this.score = taskResult.getSelf_score();
		this.time = taskResult.getPractice_time();
		this.comments = taskResult.getComments();
		this.tch_score = taskResult.getTch_score();
		this.tch_comment = taskResult.getTch_comment();
		this.clock_rank = taskResult.getClock_rank();
	}
	
	public String getTask_res_id() {
		return task_res_id;
	}

	public void setTask_res_id(String task_res_id) {
		this.task_res_id = task_res_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public float getTch_score() {
		return tch_score;
	}

	public void setTch_score(float tch_score) {
		this.tch_score = tch_score;
	}

	public String getTch_comment() {
		return tch_comment;
	}

	public void setTch_comment(String tch_comment) {
		this.tch_comment = tch_comment;
	}

	public int getClock_rank() {
        return clock_rank;
    }

    public void setClock_rank(int clock_rank) {
        this.clock_rank = clock_rank;
    }

    @Override
    public String toString() {
        return "TaskResultSimpleInf [task_res_id=" + task_res_id + ", date=" + date + ", score=" + score + ", time="
                + time + ", comments=" + comments + ", tch_score=" + tch_score + ", tch_comment=" + tch_comment
                + ", clock_rank=" + clock_rank + "]";
    }
	
}
