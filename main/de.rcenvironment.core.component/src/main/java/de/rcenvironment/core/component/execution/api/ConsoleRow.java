/*
 * Copyright (C) 2006-2014 DLR, Germany
 * 
 * All rights reserved
 * 
 * http://www.rcenvironment.de/
 */
 
package de.rcenvironment.core.component.execution.api;

import java.io.Serializable;

import de.rcenvironment.core.utils.common.StringUtils;

/**
 * Event type produced by components and workflows.
 *
 * @author Doreen Seider
 */
public interface ConsoleRow extends Comparable<ConsoleRow>, Serializable {

    /** Suffix used for publishing console notifications. */
    String NOTIFICATION_SUFFIX = ":rce.component.console";
    
    /** Type of the row. */
    public enum Type {

        /** Stdout. */
        STDOUT,

        /** Stderr. */
        STDERR,

        /**
         * Message lines that are not part of Stdout or Stderr, for example progress or status messages generated by wrappers or components.
         */
        COMPONENT_OUTPUT,

        /**
         * Lifecycle events of workflows and components. Semantically, they are related to ComponentState and WorkflowState. it is required
         * to deal with lifecycle events here as well, to reliably recognize very first and very last console row. In general, they are
         * generated by the workflow engine. Note: Actually, this type is not a console row as it was intended as ConsoleRow as a class are
         * introduced. In the future, we'll improve this probably by introducing a super type. ConsoleRow will be a child of it next to at
         * least one other for lifecycle events.
         */
        LIFE_CYCLE_EVENT;
    }

    /** Type of the workflow lifecylce event. */
    public enum WorkflowLifecyleEventType {

        /**
         * Sent at component start.
         */
        COMPONENT_STARTING,

        /**
         * Sent at component finish.
         */
        COMPONENT_TERMINATED,
        
        /**
         * Sent at component start.
         */
        COMPONENT_PAUSED,
        
        /**
         * Sent at component start.
         */
        COMPONENT_RESUMED,

        /**
         * Sent at tool start.
         */
        TOOL_STARTING,
        
        /**
         * Sent at tool finish.
         */
        TOOL_FINISHED,
        
        /**
         * Sent at workflow start.
         */
        WORKFLOW_STARTING,

        /**
         * Sent at workflow finish.
         */
        WORKFLOW_FINISHED,

        /**
         * Sent when a new WorkflowState is entered; this enum's and the new state's string form are concatenated using
         * {@link StringUtils#escapeAndConcat(String...)}.
         */
        NEW_STATE;
    }

    /**
     * @return timestamp the {@link ConsoleRow} was produced
     */
    long getTimestamp();
    
    /**
     * @return index of the {@link ConsoleRow}. Console rows can be tagged with a running index which allows sorting even if the timestamp
     *         is equal
     */
    long getIndex();
    
    /**
     * @param index index of the {@link ConsoleRow}. Console rows can be tagged with a running index which allows sorting even if the
     *        timestamp is equal
     */
    void setIndex(long index);

    /**
     * @return execution identifier of the associated workflow
     */
    String getWorkflowIdentifier();

    /**
     * @return execution identifier of the associated component
     */
    String getComponentIdentifier();

    /**
     * @return instance name of the associated workflow
     */
    String getWorkflowName();

    /**
     * @return instance name of the associated component
     */
    String getComponentName();

    /**
     * @return type of the {@link ConsoleRow}
     */
    Type getType();

    /**
     * @return payload of the {@link ConsoleRow}
     */
    String getPayload();

}
