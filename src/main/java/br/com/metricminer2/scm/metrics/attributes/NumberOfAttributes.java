package br.com.metricminer2.scm.metrics.attributes;

import java.io.ByteArrayInputStream;

import br.com.metricminer2.scm.metrics.ClassLevelCodeMetric;
import br.com.metricminer2.scm.metrics.antlr.java8.Java8AntLRVisitor;
import br.com.metricminer2.scm.metrics.common.MethodsAndAttributesListener;

public class NumberOfAttributes implements ClassLevelCodeMetric {

	private MethodsAndAttributesListener visitor;

	@Override
	public double calculate(String sourceCode) {
		try {
			
			visitor = new MethodsAndAttributesListener();
			new Java8AntLRVisitor().visit(visitor, new ByteArrayInputStream(sourceCode.getBytes()));
			
			return visitor.getAttributes().size();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}

	@Override
	public boolean accepts(String fileName) {
		return fileName.endsWith(".java");
	}

	@Override
	public String getName() {
		return "number-of-attributes";
	}

}
