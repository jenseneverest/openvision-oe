DESCRIPTION = "PluginSkinMover"
LICENSE = "GPLv3"
MAINTAINER = "Open Vision Developers"
AUTHOR = "mfaraj and schomi"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/OpenVisionE2/PluginSkinMover.git;protocol=git"

inherit gitpkgv distutils-openplugins gettext

S = "${WORKDIR}/git"

PV = "0.6+git${SRCPV}"
PKGV = "0.6+git${GITPKGV}"

python populate_packages_prepend() {
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.py$', 'enigma2-plugin-%s-src', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
}
