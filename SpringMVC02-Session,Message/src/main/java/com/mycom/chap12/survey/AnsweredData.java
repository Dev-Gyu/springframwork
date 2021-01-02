package com.mycom.chap12.survey;

import java.util.List;

public class AnsweredData {
	private List<String> responses;
	private Respondent respondent;
	
	public List<String> getResponses(){
		return responses;
	}

	public Respondent getRespondent() {
		return respondent;
	}

	public void setRespondent(Respondent respondent) {
		this.respondent = respondent;
	}

	public void setResponses(List<String> responses) {
		this.responses = responses;
	}
}
