/*
 * Copyright (C) 2006-2014 DLR, Germany
 * 
 * All rights reserved
 * 
 * http://www.rcenvironment.de/
 */

package de.rcenvironment.core.eventlog.internal;

/**
 * The internal type marker for event log messages.
 * 
 * @author Robert Mischke
 */

public enum EventLogMessageType {
    /**
     * @see EventLogger#info(boolean, String, Object...)
     */
    INFO,
    /**
     * @see EventLogger#warn(boolean, String, Object...)
     */
    WARNING,
    /**
     * @see EventLogger#error(boolean, String, Object...)
     */
    ERROR,
    /**
     * @see EventLogger#debug(String, Object...)
     */
    DEBUG_DEFAULT,
    /**
     * @see EventLogger#debugVerbose(String, Object...)
     */
    DEBUG_VERBOSE,
    /**
     * @see ComponentEventLogger#stdout(String)
     */
    STDOUT,
    /**
     * @see ComponentEventLogger#stderr(String)
     */
    STDERR;
}
