/*
 * Copyright (C) 2006-2014 DLR, Germany
 * 
 * All rights reserved
 * 
 * http://www.rcenvironment.de/
 */

package de.rcenvironment.core.component.workflow.execution.api;

import java.io.File;

import de.rcenvironment.core.component.api.SingleConsoleRowsProcessor;
import de.rcenvironment.core.component.workflow.model.api.WorkflowDescription;
import de.rcenvironment.core.utils.common.textstream.TextOutputReceiver;

/**
 * Service for executing workflow files without a graphical interface.
 * 
 * @author Sascha Zur
 * @author Robert Mischke
 * @author Doreen Seider
 */
public interface HeadlessWorkflowExecutionService {

    /**
     * Dispose behavior after workflow execution.
     * 
     * @author Doreen Seider
     */
    enum Dispose {
        Always,
        Never,
        OnFinished;
    }
    
    /**
     * Loads the given workflow file and tries to parse it into a {@link WorkflowDescription}. This method performs the same steps as if
     * this workflow file was passed to {@link #executeWorkflow()}, including format upgrades.
     * 
     * @param wfFile the workflow file
     * @param outputReceiver a reveiver for end-user feedback
     * @return the parsed {@link WorkflowDescription}, if successful
     * @throws WorkflowExecutionException on failure to read/parse the workflow file
     */
    // Why does this method throw a Workflow_Execution_Exception if this method doesn't execute a workflow? -seid_do
    WorkflowDescription parseWorkflowFile(File wfFile, TextOutputReceiver outputReceiver) throws WorkflowExecutionException;

    /**
     * Checks if the components of the workflow are installed on the configured target nodes and if the configured controller node is
     * available.
     * 
     * @param workflowDescription {@link WorkflowDescription} to validate
     * @return <code>true</code> if workflow is valid regarding the checks described above (at that single moment), otherwise
     *         <code>false</code>
     */
    boolean isWorkflowDescriptionValid(WorkflowDescription workflowDescription);
    
    /**
     * Checks whether the given file is a proper placeholder values file.
     * 
     * @param placeholdersFile the file to check
     * @throws WorkflowExecutionException if the file is invalid
     */
    void validatePlaceholdersFile(File placeholdersFile) throws WorkflowExecutionException;

    /**
     * Loads the given workflow file and attempts to run it.
     * 
     * @param wfFile the workflow file
     * @param placeholdersFile an optional JSON file containing componentId->(key->value) placeholder values
     * @param customLogDirectory optional parameter to set the location for workflow log files; leave null for default
     * @param outputReceiver the {@link TextOutputReceiver} to write status messages to
     * @param customConsoleRowReceiver an optional listener for all received ConsoleRows; pass null to deactivate
     * @param dispose {@link Dispose} behavior. Default is {@link Dispose#OnFinished}
     * @return the state that the workflow finished with
     * @throws WorkflowExecutionException on execution failure
     */
    FinalWorkflowState executeWorkflow(File wfFile, File placeholdersFile, File customLogDirectory,
        TextOutputReceiver outputReceiver, SingleConsoleRowsProcessor customConsoleRowReceiver, Dispose dispose)
        throws WorkflowExecutionException;
    
    /**
     * Loads the given workflow file and attempts to run it.
     * 
     * @param wfFile the workflow file
     * @param placeholdersFile an optional JSON file containing componentId->(key->value) placeholder values
     * @param customLogDirectory optional parameter to set the location for workflow log files; leave null for default
     * @param outputReceiver the {@link TextOutputReceiver} to write status messages to
     * @param customConsoleRowReceiver an optional listener for all received ConsoleRows; pass null to deactivate
     * @return the state that the workflow finished with
     * @throws WorkflowExecutionException on execution failure
     */
    FinalWorkflowState executeWorkflow(File wfFile, File placeholdersFile, File customLogDirectory,
        TextOutputReceiver outputReceiver, SingleConsoleRowsProcessor customConsoleRowReceiver)
        throws WorkflowExecutionException;

}
