/*
 * Copyright 2006-2019 DLR, Germany
 * 
 * SPDX-License-Identifier: EPL-1.0
 * 
 * http://www.rcenvironment.de/
 */

package de.rcenvironment.components.script.execution.python;

import de.rcenvironment.components.script.common.registry.ScriptExecutor;
import de.rcenvironment.components.script.common.registry.ScriptExecutorFactory;
import de.rcenvironment.components.script.execution.python.internal.PythonScriptExecutor;
import de.rcenvironment.core.utils.scripting.ScriptLanguage;

/**
 * Factory for the Python script language executor.
 * 
 * @author Sascha Zur
 */
public class PythonScriptExecutorFactory implements ScriptExecutorFactory {

    @Override
    public ScriptLanguage getSupportingScriptLanguage() {
        return ScriptLanguage.Python;
    }

    @Override
    public ScriptExecutor createScriptExecutor() {
        return new PythonScriptExecutor();
    }

}
