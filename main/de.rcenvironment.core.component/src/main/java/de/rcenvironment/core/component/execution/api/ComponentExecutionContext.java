/*
 * Copyright (C) 2006-2014 DLR, Germany
 * 
 * All rights reserved
 * 
 * http://www.rcenvironment.de/
 */
 
package de.rcenvironment.core.component.execution.api;

import java.io.File;
import java.util.List;
import java.util.Map;

import de.rcenvironment.core.communication.common.NodeIdentifier;
import de.rcenvironment.core.component.model.api.ComponentDescription;
import de.rcenvironment.core.component.model.endpoint.api.EndpointDatumRecipient;

/**
 * Component-specific {@link ExecutionContext}.
 * 
 * @author Doreen Seider
 */
public interface ComponentExecutionContext extends ExecutionContext {

    /**
     * @return {@link ComponentDescription} of the component executed
     */
    ComponentDescription getComponentDescription();
    
    /**
     * @return <code>true</code> if the component executed receives {@link EndpointDatum}s from other components, otherwise
     *         <code>false</code>
     */
    boolean isConnectedToEndpointDatumSenders();

    /**
     * @return {@link EndpointDatumRecipient} sorted by component's output names
     */
    Map<String, List<EndpointDatumRecipient>> getEndpointDatumRecipients();
    
    /**
     * @return the workflow node id of the component executed within associated workflow
     */
    NodeIdentifier getWorkflowNodeId();
    
    /**
     * @return execution identifier of the associated workflow
     */
    String getWorkflowExecutionIdentifier();
    
    /**
     * @return instance name of the associated workflow
     */
    String getWorkflowInstanceName();
    
    /**
     * @return {@link WorkflowGraph} instance with graph information of the associated workflow
     */
    WorkflowGraph getWorkflowGraph();
    
    /**
     * @return working directory execution identifier of the associated workflow
     */
    File getWorkingDirectory();
    
    /**
     * @return data management id of the component instance
     */
    Long getInstanceDataManagementId();
    
    /**
     * @return data management id of the workflow instance
     */
    Long getWorkflowInstanceDataManagementId();
    
    /**
     * @return data management ids of the inputs
     */
    Map<String, Long> getInputDataManagementIds();
    
    /**
     * @return data management ids of the outputs
     */
    Map<String, Long> getOutputDataManagementIds();

}
