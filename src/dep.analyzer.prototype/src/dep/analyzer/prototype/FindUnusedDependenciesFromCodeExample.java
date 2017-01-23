package dep.analyzer.prototype;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.pde.internal.core.bundle.WorkspaceBundlePluginModel;
import org.eclipse.pde.internal.ui.search.dependencies.UnusedDependenciesJob;
import org.junit.Test;

@SuppressWarnings("restriction")
public class FindUnusedDependenciesFromCodeExample {
	@Test
	public void runExample() throws Exception {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject project  = root.getProject("dep.analyzer.prototype");
		IFolder folder = project.getFolder("META-INF");
		IFile file = folder.getFile("MANIFEST.MF");
		IFile pluginXMLFile = project.getFile("plugin.xml");
		WorkspaceBundlePluginModel workspaceBundlePluginModel = new WorkspaceBundlePluginModel(file,pluginXMLFile);
		UnusedDependenciesJob unusedDependenciesJob = new UnusedDependenciesJob("MyJob", workspaceBundlePluginModel, true);
		unusedDependenciesJob.schedule();
		
		Thread.sleep(5000);
	}
}
