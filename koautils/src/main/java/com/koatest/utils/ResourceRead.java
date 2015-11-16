package com.koatest.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class ResourceRead {
 
	public List<String> readLines(String resource, String regex) throws IOException {
		List<String> result = new ArrayList<>();
		Pattern p = Pattern.compile(regex==null?"":regex);
		String path = getClass().getResource(resource).getPath();
		Stream<String> lines = Files.lines(new File(path).toPath(), Charset.forName("UTF-8"));
		lines.map(s -> s.trim())
			.filter(s -> !s.isEmpty())
			.filter(s -> regex==null || p.matcher(s).matches())
			.forEach(s -> result.add(s));
		lines.close();
		return result;
	}
}
