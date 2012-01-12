package org.mdd.examples.coder.master;

import org.mdd.examples.coder.Code;
import org.mdd.examples.coder.Coder;
import org.mdd.examples.coder.Complexity;
import org.mdd.examples.coder.Correctness;
import org.mdd.examples.coder.Size;

public class MasterCoder implements Coder
{
    private final DesignPrinciples principles;
    private final Experience experience;
    
    public MasterCoder(DesignPrinciples principles, Experience experience)
    {
        this.principles = principles;
        this.experience = experience;
    }
    
    @Override
    public Code writeCodeFor(String[] requirements)
    {
        Task[] tasks = experience.breakIntoTasks(requirements);
        for(Task t : tasks)
        {
            Code c = principles.apply(t);
        }
        return new Code(Complexity.LOW, Size.SMALL, Correctness.PERFECT);
    }
}
