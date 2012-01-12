package org.mdd.examples.coder.master;

import org.junit.Before;
import org.junit.Test;
import org.mdd.examples.coder.Code;
import org.mdd.examples.coder.Complexity;
import org.mdd.examples.coder.Correctness;
import org.mdd.examples.coder.Size;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestMasterCoder
{
    private static final String[] REQUIREMENTS = {"simple requirement"}; 
    
    private MasterCoder coder;
    private Task task;
    private Task[] tasks;
    private Experience experience;
    private DesignPrinciples principles;
    private Code code;
    
    @Before
    public void setup()
    {
        experience = mock(Experience.class);
        principles = mock(DesignPrinciples.class);
        code = mock(Code.class);
        task = new Task();
        tasks = new Task[]{task};
        
        coder = new MasterCoder(principles, experience);
    }
    
    @Test
    public void shouldWriteSimpleCode()
    {
        when(experience.breakIntoTasks(REQUIREMENTS)).thenReturn(tasks);
        when(principles.apply(task)).thenReturn(code);
        
        Code code = coder.writeCodeFor(REQUIREMENTS);
        assertEquals(Complexity.LOW, code.getComplexity());
        assertEquals(Correctness.PERFECT, code.getCorrectness());
        assertEquals(Size.SMALL, code.getCodeSize());
    }
}
