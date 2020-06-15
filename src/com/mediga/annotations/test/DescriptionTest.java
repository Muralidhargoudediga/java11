package com.mediga.annotations.test;

import com.mediga.annotations.Description;
import com.mediga.annotations.Name;
import com.mediga.annotations.Version;

@Description(name = @Name(firstName = "Muralidha", lastName = "Goud"), version = @Version(major = 1), comments = "Just a test class")
public class DescriptionTest {
}
