DESCRIPTION = "RSi Config by OpenRSi"
DEPENDS = "python-native"
require conf/license/openvision-gplv2.inc

inherit gitpkgv pkgconfig rm_python_pyc compile_python_pyo no_python_src

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenE2/rsiconfig-plugin.git;protocol=git"

S = "${WORKDIR}/git"

do_install() {
	install -d  ${D}${libdir}/enigma2/python/Plugins/Extensions/RSIConfig
	install -d  ${D}${libdir}/enigma2/python/Plugins/Extensions/RSIConfig/keymaps

	install -m 0644 ${S}/*.pyo \
	${D}${libdir}/enigma2/python/Plugins/Extensions/RSIConfig
	
	install -m 0755 ${S}/ntp* \
	${D}${libdir}/enigma2/python/Plugins/Extensions/RSIConfig
	
	install -m 0755 ${S}/dvb* \
	${D}${libdir}/enigma2/python/Plugins/Extensions/RSIConfig
	
	install -m 0755 ${S}/man* \
	${D}${libdir}/enigma2/python/Plugins/Extensions/RSIConfig
	
	install -m 0755 ${S}/keymaps/*.xml \
	${D}${libdir}/enigma2/python/Plugins/Extensions/RSIConfig/keymaps
}

FILES_${PN} = "${libdir}/enigma2/python/Plugins/Extensions/RSIConfig"

PACKAGES = "enigma2-plugin-extensions-rsiconfig"

PROVIDES="${PACKAGES}"
