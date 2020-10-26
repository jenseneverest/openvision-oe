DESCRIPTION = "Azbox VideoSettingsSetup plugin"
DEPENDS = "python-native"
require conf/license/openvision-gplv2.inc

inherit gitpkgv pkgconfig rm_python_pyc compile_python_pyo no_python_src

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/VideoSettingsSetup.git;protocol=git"

S = "${WORKDIR}/git"

do_install() {
	install -d  ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/VideoSettingsSetup
	install -m 0644 ${S}/*.pyo ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/VideoSettingsSetup
}

FILES_${PN} = "${libdir}/enigma2/python/Plugins/SystemPlugins/VideoSettingsSetup"

PACKAGES = "enigma2-plugin-systemplugins-videosettingssetup"

PROVIDES="${PACKAGES}"
