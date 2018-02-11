package com.mss.spring.batch.batchcomponents;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import components.CompositeData;

public class BatchItemWriter implements ItemWriter<CompositeData> {

	@Override
	public void write(List<? extends CompositeData> compositeData) throws Exception {
		System.out.println("WRITER SIZEEEEE :" + compositeData.size());
		for (CompositeData np : compositeData) {
			if (np.getNewPerson() != null)
				System.out.println(np.getNewPerson().getNameLastName());
			if (np.getNewPerson2() != null)
				System.out.println(np.getNewPerson2().getLastNameName());
		}
	}
}
