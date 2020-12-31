SUMMARY = "Australia Picons"
SECTION = "base"
PRIORITY = "required"
MAINTAINER = "Beyonwiz"
require conf/license/license-gplv2.inc

inherit allarch gitpkgv

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI="git://bitbucket.org/beyonwiz/picons-australia.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

PACKAGES = "${PN}"

FILES_${PN} = "/picon/* /piconlcd/*"

do_install() {
	cp -rp ${S}/picon ${D}/
	cp -rp ${S}/piconlcd ${D}/
}

do_package_qa[noexec] = "1"
