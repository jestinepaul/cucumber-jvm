package cuke4duke.internal.language;

import static junit.framework.Assert.assertEquals;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import cuke4duke.internal.java.JavaHook;

public class AbstractProgrammingLanguageTest {

    private Method method;
    private JavaHook transformHook;

    @Before
    public void setUp() {
        this.transformHook = new JavaHook(method, null);
    }

    @Test
    public void shouldAddTransformHooksToTransformsMap() throws Throwable {
        AbstractProgrammingLanguage programmingLanguage = new TestProgrammingLanguage(null);
        programmingLanguage.prepareScenario();
        programmingLanguage.addTransformHook(Integer.TYPE, transformHook);
        assertEquals(transformHook, programmingLanguage.getTransforms().get(Integer.TYPE));
    }

    private class TestProgrammingLanguage extends AbstractProgrammingLanguage {

        public TestProgrammingLanguage(LanguageMixin languageMixin) {
            super(languageMixin);
        }

        @Override
        public void cleanupScenario() throws Throwable {
            // TODO Auto-generated method stub

        }

        @Override
        public void load_code_file(String file) throws Throwable {
            // TODO Auto-generated method stub

        }

        @Override
        protected void prepareScenario() throws Throwable {
            clearHooksAndStepDefinitions();
        }

    }
}