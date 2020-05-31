package com.Match_My_PC.application.graphql;

import com.Match_My_PC.domain.PC;
import com.Match_My_PC.domain.PCService;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class PCResolver {

    private PCService pcService ;

    public PCResolver(PCService pcService) {
        this.pcService = pcService;
    }

    @GraphQLQuery
    public List<PC> getPCS (){
        return pcService.getPCS();
    }
}
