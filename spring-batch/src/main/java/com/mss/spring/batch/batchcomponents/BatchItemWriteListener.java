package com.mss.spring.batch.batchcomponents;

import java.sql.BatchUpdateException;
import java.util.List;

import javax.batch.api.chunk.listener.ItemWriteListener;

public class BatchItemWriteListener implements ItemWriteListener {

	@Override
	public void afterWrite(List<Object> arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeWrite(List<Object> arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void onWriteError(List<Object> personList, Exception e) throws Exception {
		if (e.getCause() instanceof BatchUpdateException) {
			BatchUpdateException bue = (BatchUpdateException) e.getCause();
			bue.getUpdateCounts();
			//TODO: Handle failed transaction
		}

	}

}
