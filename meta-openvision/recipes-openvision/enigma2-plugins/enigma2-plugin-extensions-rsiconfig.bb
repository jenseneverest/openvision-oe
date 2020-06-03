DESCRIPTION = "RSi Config by OpenRSi"
DEPENDS = "python-native"
require conf/license/openvision-gplv2.inc

inherit gitpkgv pkgconfig rm_python_pyc compile_python_pyo no_python_src

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenE2/rsiconfig-plugin.git;protocol=git"

S = "${WORKDIR}/git"

python populate_packages_prepend () {
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.py$', 'enigma2-plugin-%s-src', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.la$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.a$', 'enigma2-plugin-%s-staticdev', '%s (static development)', recursive=True, match_path=True, prepend=True)
}

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
