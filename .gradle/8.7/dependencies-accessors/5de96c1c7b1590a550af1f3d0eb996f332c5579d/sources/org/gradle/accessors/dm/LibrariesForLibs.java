package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final JunitLibraryAccessors laccForJunitLibraryAccessors = new JunitLibraryAccessors(owner);
    private final OrgLibraryAccessors laccForOrgLibraryAccessors = new OrgLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Group of libraries at <b>junit</b>
     */
    public JunitLibraryAccessors getJunit() {
        return laccForJunitLibraryAccessors;
    }

    /**
     * Group of libraries at <b>org</b>
     */
    public OrgLibraryAccessors getOrg() {
        return laccForOrgLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class JunitLibraryAccessors extends SubDependencyFactory {

        public JunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>junit</b> with <b>junit:junit</b> coordinates and
         * with version reference <b>junit.junit</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit() {
            return create("junit.junit");
        }

    }

    public static class OrgLibraryAccessors extends SubDependencyFactory {
        private final OrgSeleniumhqLibraryAccessors laccForOrgSeleniumhqLibraryAccessors = new OrgSeleniumhqLibraryAccessors(owner);

        public OrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.seleniumhq</b>
         */
        public OrgSeleniumhqLibraryAccessors getSeleniumhq() {
            return laccForOrgSeleniumhqLibraryAccessors;
        }

    }

    public static class OrgSeleniumhqLibraryAccessors extends SubDependencyFactory {
        private final OrgSeleniumhqSeleniumLibraryAccessors laccForOrgSeleniumhqSeleniumLibraryAccessors = new OrgSeleniumhqSeleniumLibraryAccessors(owner);

        public OrgSeleniumhqLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.seleniumhq.selenium</b>
         */
        public OrgSeleniumhqSeleniumLibraryAccessors getSelenium() {
            return laccForOrgSeleniumhqSeleniumLibraryAccessors;
        }

    }

    public static class OrgSeleniumhqSeleniumLibraryAccessors extends SubDependencyFactory {
        private final OrgSeleniumhqSeleniumSeleniumLibraryAccessors laccForOrgSeleniumhqSeleniumSeleniumLibraryAccessors = new OrgSeleniumhqSeleniumSeleniumLibraryAccessors(owner);

        public OrgSeleniumhqSeleniumLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.seleniumhq.selenium.selenium</b>
         */
        public OrgSeleniumhqSeleniumSeleniumLibraryAccessors getSelenium() {
            return laccForOrgSeleniumhqSeleniumSeleniumLibraryAccessors;
        }

    }

    public static class OrgSeleniumhqSeleniumSeleniumLibraryAccessors extends SubDependencyFactory {

        public OrgSeleniumhqSeleniumSeleniumLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>java</b> with <b>org.seleniumhq.selenium:selenium-java</b> coordinates and
         * with version reference <b>org.seleniumhq.selenium.selenium.java</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJava() {
            return create("org.seleniumhq.selenium.selenium.java");
        }

        /**
         * Dependency provider for <b>server</b> with <b>org.seleniumhq.selenium:selenium-server</b> coordinates and
         * with version reference <b>org.seleniumhq.selenium.selenium.server</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getServer() {
            return create("org.seleniumhq.selenium.selenium.server");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final JunitVersionAccessors vaccForJunitVersionAccessors = new JunitVersionAccessors(providers, config);
        private final OrgVersionAccessors vaccForOrgVersionAccessors = new OrgVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.junit</b>
         */
        public JunitVersionAccessors getJunit() {
            return vaccForJunitVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org</b>
         */
        public OrgVersionAccessors getOrg() {
            return vaccForOrgVersionAccessors;
        }

    }

    public static class JunitVersionAccessors extends VersionFactory  {

        public JunitVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>junit.junit</b> with value <b>4.13.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJunit() { return getVersion("junit.junit"); }

    }

    public static class OrgVersionAccessors extends VersionFactory  {

        private final OrgSeleniumhqVersionAccessors vaccForOrgSeleniumhqVersionAccessors = new OrgSeleniumhqVersionAccessors(providers, config);
        public OrgVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.seleniumhq</b>
         */
        public OrgSeleniumhqVersionAccessors getSeleniumhq() {
            return vaccForOrgSeleniumhqVersionAccessors;
        }

    }

    public static class OrgSeleniumhqVersionAccessors extends VersionFactory  {

        private final OrgSeleniumhqSeleniumVersionAccessors vaccForOrgSeleniumhqSeleniumVersionAccessors = new OrgSeleniumhqSeleniumVersionAccessors(providers, config);
        public OrgSeleniumhqVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.seleniumhq.selenium</b>
         */
        public OrgSeleniumhqSeleniumVersionAccessors getSelenium() {
            return vaccForOrgSeleniumhqSeleniumVersionAccessors;
        }

    }

    public static class OrgSeleniumhqSeleniumVersionAccessors extends VersionFactory  {

        private final OrgSeleniumhqSeleniumSeleniumVersionAccessors vaccForOrgSeleniumhqSeleniumSeleniumVersionAccessors = new OrgSeleniumhqSeleniumSeleniumVersionAccessors(providers, config);
        public OrgSeleniumhqSeleniumVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.seleniumhq.selenium.selenium</b>
         */
        public OrgSeleniumhqSeleniumSeleniumVersionAccessors getSelenium() {
            return vaccForOrgSeleniumhqSeleniumSeleniumVersionAccessors;
        }

    }

    public static class OrgSeleniumhqSeleniumSeleniumVersionAccessors extends VersionFactory  {

        public OrgSeleniumhqSeleniumSeleniumVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.seleniumhq.selenium.selenium.java</b> with value <b>3.141.59</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJava() { return getVersion("org.seleniumhq.selenium.selenium.java"); }

        /**
         * Version alias <b>org.seleniumhq.selenium.selenium.server</b> with value <b>3.141.59</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getServer() { return getVersion("org.seleniumhq.selenium.selenium.server"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
