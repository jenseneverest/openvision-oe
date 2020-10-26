DESCRIPTION = "OFW Launcher by Ping Flood"
DEPENDS = "python-native"
require conf/license/openvision-gplv2.inc

inherit gitpkgv pkgconfig rm_python_pyc compile_python_pyo no_python_src

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenE2/ofwlauncher-plugin.git;protocol=git"

S = "${WORKDIR}/git"

do_install() {
	install -d  ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/OFW_Launcher
	install -m 0644 ${S}/*.pyo \
	${D}${libdir}/enigma2/python/Plugins/SystemPlugins/OFW_Launcher
}

FILES_${PN} = "${libdir}/enigma2/python/Plugins/SystemPlugins/OFW_Launcher"

PACKAGES = "enigma2-plugin-systemplugins-ofwlauncher"

PROVIDES="${PACKAGES}"
