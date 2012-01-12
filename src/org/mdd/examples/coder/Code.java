package org.mdd.examples.coder;

public class Code
{
    private Complexity complexity;
    private Size codeSize;
    private Correctness correctness;
    
    public Code()
    {};
    
    public Code(Complexity complexity, Size codeSize, Correctness correctness)
    {
        this.complexity = complexity;
        this.codeSize = codeSize;
        this.correctness = correctness;
    }
    
    public Size getCodeSize()
    {
        return this.codeSize;
    }
    
    public Complexity getComplexity()
    {
        return this.complexity;
    }

    public Correctness getCorrectness()
    {
        return correctness;
    }
}
