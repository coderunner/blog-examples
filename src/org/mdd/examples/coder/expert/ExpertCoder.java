package org.mdd.examples.coder.expert;

import org.mdd.examples.coder.Code;
import org.mdd.examples.coder.Coder;
import org.mdd.examples.coder.Complexity;
import org.mdd.examples.coder.Correctness;
import org.mdd.examples.coder.Size;

public class ExpertCoder implements Coder
{
    private final RequirementsImporter importer;
    private final DesignDiscussionGenerator generator;
    private final DesignPatternFactory factory;
    
    public ExpertCoder(RequirementsImporter importer,
            DesignDiscussionGenerator generator,
            DesignPatternFactory factory)
    {
        this.importer = importer;
        this.generator = generator;
        this.factory = factory;
    }

    @Override
    public Code writeCodeFor(String[] requirements)
    {
        Requirements reqs = importer.importRequirements(requirements);
        Requirement req = reqs.getRequirement(0);
        DesignDiscussions discussions = generator.discussDesign(req);
        DesignDiscussion discussion = discussions.getNextDiscussion();
        Problems problems = discussion.discuss();
        Problem p = problems.getNextProblem();
        DesignPattern pattern = factory.choosePattern(p);
        pattern.apply();
        return new Code(Complexity.HIGH, Size.LARGE, Correctness.MINOR_ISSUES);
    }

}
