DESCRIPTION = "Control your receiver with a browser"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README;firstline=10;lastline=12;md5=9c14f792d0aeb54e15490a28c89087f7"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "python-cheetah-native"

RDEPENDS_${PN} = "\
	aio-grab \
	python-cheetah \
	python-compression\
	python-ipaddress\
	python-json \
	python-misc \
	python-numbers \
	python-pyopenssl \
	python-shell \
	python-six \
	python-unixadmin \
	"

inherit gitpkgv distutils-openplugins gettext

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/OpenWebif.git;protocol=git"

S = "${WORKDIR}/git"

do_compile() {
	cheetah-compile -R --nobackup ${S}/plugin
}

PLUGINPATH = "${libdir}/enigma2/python/Plugins/Extensions/OpenWebif"
do_install_append() {
	install -d ${D}${PLUGINPATH}
	cp -r ${S}/plugin/* ${D}${PLUGINPATH}
	chmod a+rX ${D}${PLUGINPATH}
}

FILES_${PN} = "${PLUGINPATH}"

do_install_append() {
	install -d ${D}${PLUGINPATH}
	cp -r ${S}/plugin/* ${D}${PLUGINPATH}
	chmod a+rX ${D}${PLUGINPATH}/
	rm -f ${D}${PLUGINPATH}/public/images/boxes/*.png
	rm -f ${D}${PLUGINPATH}/public/images/remotes/*.png
	rm -f ${D}${PLUGINPATH}/public/static/remotes/*.html
	install -m 0644 ${S}/plugin/public/images/boxes/unknown.png ${D}${PLUGINPATH}/public/images/boxes/
	install -m 0644 ${S}/plugin/public/images/remotes/ow_remote.png ${D}${PLUGINPATH}/public/images/remotes/
	install -m 0644 ${S}/plugin/public/images/remotes/dmm1.png ${D}${PLUGINPATH}/public/images/remotes/
	install -m 0644 ${S}/plugin/public/static/remotes/dmm1.html ${D}${PLUGINPATH}/public/static/remotes/
	if [ -e "${S}/plugin/public/images/boxes/${MACHINE}.png" ]; then
		install -m 0644 ${S}/plugin/public/images/boxes/${MACHINE}.png ${D}${PLUGINPATH}/public/images/boxes/
	fi
	if [ -e "${S}/plugin/public/images/remotes/${RCNAME}.png" ]; then
		install -m 0644 ${S}/plugin/public/images/remotes/${RCNAME}.png ${D}${PLUGINPATH}/public/images/remotes/
		install -m 0644 ${S}/plugin/public/static/remotes/${RCNAME}.html ${D}${PLUGINPATH}/public/static/remotes/
	fi
}

FILES_${PN} = "${PLUGINPATH}"

RPROVIDES_${PN} =+ "${PN}-vxg ${PN}-themes ${PN}-terminal"
PACKAGES =+ "${PN}-vxg ${PN}-themes ${PN}-terminal"
FILES_${PN}-vxg = "${libdir}/enigma2/python/Plugins/Extensions/OpenWebif/public/vxg"
FILES_${PN}-themes = "${libdir}/enigma2/python/Plugins/Extensions/OpenWebif/public/themes"

DESCRIPTION_${PN}-terminal = "CLI for OpenWebif"
RDEPENDS_${PN}-terminal = "${PN} shellinabox"
RREPLACES_${PN}-terminal = "enigma2-plugin-extensions-openwebif-terminal"
RCONFLICTS_${PN}-terminal = "enigma2-plugin-extensions-openwebif-terminal"
RPROVIDES_${PN}-terminal =+ "enigma2-plugin-extensions-openwebif-terminal"
