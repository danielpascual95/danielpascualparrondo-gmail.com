/*! ******************************************************************************
*
* Pentaho Data Integration
*
* Copyright (C) 2002-2013 by Pentaho : http://www.pentaho.com
*
*******************************************************************************
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with
* the License. You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*
******************************************************************************/

package org.pentaho.di.sdk.samples.steps.demo;


import org.pentaho.di.core.exception.KettleStepException;
import org.pentaho.di.core.row.RowMeta;
import org.pentaho.di.core.row.RowMetaInterface;
import org.pentaho.di.core.row.value.ValueMetaString;

import junit.framework.TestCase;

public class DemoStepTest extends TestCase {

	public void testStepMeta() throws KettleStepException{
		
		
		DemoStepMeta m = new DemoStepMeta();
		m.setDefault();
		
		RowMetaInterface rowMeta = new RowMeta();
		m.getFields(rowMeta, "demo_step", null, null, null, null, null);
		
		// expect one field to be added to the row stream
		assertEquals(rowMeta.size(), 1);
		
		// that field must be a string and named as configured
		assertEquals(rowMeta.getValueMeta(0).getType(), ValueMetaString.TYPE_STRING);
		assertEquals(rowMeta.getValueMeta(0).getStorageType(), ValueMetaString.STORAGE_TYPE_NORMAL);
		assertEquals(rowMeta.getFieldNames()[0], m.getOutputField());
		
	}
	
}
