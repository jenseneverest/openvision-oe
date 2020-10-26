DESCRIPTION = "Keymap Config by Ping Flood"
DEPENDS = "python-native"
require conf/license/openvision-gplv2.inc

inherit gitpkgv pkgconfig rm_python_pyc compile_python_pyo no_python_src

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/pingflood/keymapconfig.git;protocol=git"

S = "${WORKDIR}/git"

do_install() {
	install -d  ${D}${libdir}/enigma2/python/Plugins/Extensions/KeymapConfig
	
	install -m 0644 ${S}/*.pyo \
	${D}${libdir}/enigma2/python/Plugins/Extensions/KeymapConfig

        install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/KeymapConfig/keymap/
        install -m 0644 ${S}/keymap/*.xml ${D}${libdir}/enigma2/python/Plugins/Extensions/KeymapConfig/keymap/
}

FILES_${PN} = "${libdir}/enigma2/python/Plugins/Extensions/KeymapConfig"

PACKAGES = "enigma2-plugin-extensions-keymapconfig"

PROVIDES="${PACKAGES}"
